<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="consumePointsDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 차감
                </v-btn>
                <v-dialog v-model="consumePointsDialog" width="500">
                    <ConsumePoints
                        @closeDialog="consumePointsDialog = false"
                        @consumePoints="consumePoints"
                    ></ConsumePoints>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="grantPointsDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 지급
                </v-btn>
                <v-dialog v-model="grantPointsDialog" width="500">
                    <GrantPoints
                        @closeDialog="grantPointsDialog = false"
                        @grantPoints="grantPoints"
                    ></GrantPoints>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="registerUserDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>회원 가입
                </v-btn>
                <v-dialog v-model="registerUserDialog" width="500">
                    <RegisterUser
                        @closeDialog="registerUserDialog = false"
                        @registerUser="registerUser"
                    ></RegisterUser>
                </v-dialog>
            </div>
            <UserPointHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserPointHistory>
            <UserProfile @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserProfile>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>KtCustomer</th>
                        <th>Points</th>
                        <th>포인트 지갑 ID</th>
                        <th>구독 ID</th>
                        <th>포인트 지갑</th>
                        <th>구독</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Name">{{ val.name }}</td>
                            <td class="whitespace-nowrap" label="KtCustomer">{{ val.ktCustomer }}</td>
                            <td class="whitespace-nowrap" label="Points">{{ val.points }}</td>
                            <td class="whitespace-nowrap" label="포인트 지갑">
                                <PointWalletId :editMode="editMode" v-model="val.pointWalletId"></PointWalletId>
                            </td>
                            <td class="whitespace-nowrap" label="구독">
                                <SubscriptionId :editMode="editMode" v-model="val.subscriptionId"></SubscriptionId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">User 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <User :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">User 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="UserId" v-model="selectedRow.userId" :editMode="true"/>
                            <String label="Name" v-model="selectedRow.name" :editMode="true"/>
                            <Boolean label="KtCustomer" v-model="selectedRow.ktCustomer" :editMode="true"/>
                            <Number label="Points" v-model="selectedRow.points" :editMode="true"/>
                            <Number offline label="포인트 지갑 ID" v-model="selectedRow.pointWalletId" :editMode="true"/>
                            <SubscriptionId offline label="구독 ID" v-model="selectedRow.subscriptionId" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'userGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'users',
        consumePointsDialog: false,
        grantPointsDialog: false,
        registerUserDialog: false,
    }),
    watch: {
    },
    methods:{
        async consumePoints(params){
            try{
                var path = "consumePoints".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ConsumePoints 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.consumePointsDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async grantPoints(params){
            try{
                var path = "grantPoints".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GrantPoints 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.grantPointsDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async registerUser(params){
            try{
                var path = "registerUser".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RegisterUser 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.registerUserDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>