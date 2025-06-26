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
                <v-btn style="margin-left: 5px;" @click="grantPointsToWalletDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 적립
                </v-btn>
                <v-dialog v-model="grantPointsToWalletDialog" width="500">
                    <GrantPointsToWallet
                        @closeDialog="grantPointsToWalletDialog = false"
                        @grantPointsToWallet="grantPointsToWallet"
                    ></GrantPointsToWallet>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="recordPointHistoryEntryDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 변동 내역 기록
                </v-btn>
                <v-dialog v-model="recordPointHistoryEntryDialog" width="500">
                    <RecordPointHistoryEntry
                        @closeDialog="recordPointHistoryEntryDialog = false"
                        @recordPointHistoryEntry="recordPointHistoryEntry"
                    ></RecordPointHistoryEntry>
                </v-dialog>
            </div>
            <PointWalletBalance @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PointWalletBalance>
            <PointWalletHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PointWalletHistory>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>UserId</th>
                        <th>KtCustomer</th>
                        <th>Points</th>
                        <th>PointHistory</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="UserId">{{ val.userId }}</td>
                            <td class="whitespace-nowrap" label="KtCustomer">{{ val.ktCustomer }}</td>
                            <td class="whitespace-nowrap" label="Points">{{ val.points }}</td>
                            <td class="whitespace-nowrap" label="PointHistory">{{ val.pointHistory }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">PointWallet 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <PointWallet :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">PointWallet 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="PointWalletId" v-model="selectedRow.pointWalletId" :editMode="true"/>
                            <String label="UserId" v-model="selectedRow.userId" :editMode="true"/>
                            <Boolean label="KtCustomer" v-model="selectedRow.ktCustomer" :editMode="true"/>
                            <Number label="Points" v-model="selectedRow.points" :editMode="true"/>
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
    name: 'pointWalletGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'pointWallets',
        grantPointsToWalletDialog: false,
        recordPointHistoryEntryDialog: false,
    }),
    watch: {
    },
    methods:{
        async grantPointsToWallet(params){
            try{
                var path = "grantPointsToWallet".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GrantPointsToWallet 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.grantPointsToWalletDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async recordPointHistoryEntry(params){
            try{
                var path = "recordPointHistoryEntry".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RecordPointHistoryEntry 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.recordPointHistoryEntryDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>