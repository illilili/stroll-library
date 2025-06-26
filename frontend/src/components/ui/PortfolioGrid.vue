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
                <v-btn style="margin-left: 5px;" @click="createPortfolioDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포트폴리오 등록
                </v-btn>
                <v-dialog v-model="createPortfolioDialog" width="500">
                    <CreatePortfolio
                        @closeDialog="createPortfolioDialog = false"
                        @createPortfolio="createPortfolio"
                    ></CreatePortfolio>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="deletePortfolioDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포트폴리오 삭제
                </v-btn>
                <v-dialog v-model="deletePortfolioDialog" width="500">
                    <DeletePortfolio
                        @closeDialog="deletePortfolioDialog = false"
                        @deletePortfolio="deletePortfolio"
                    ></DeletePortfolio>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePortfolioDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포트폴리오 수정
                </v-btn>
                <v-dialog v-model="updatePortfolioDialog" width="500">
                    <UpdatePortfolio
                        @closeDialog="updatePortfolioDialog = false"
                        @updatePortfolio="updatePortfolio"
                    ></UpdatePortfolio>
                </v-dialog>
            </div>
            <PortfolioDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PortfolioDetails>
            <PortfolioList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PortfolioList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>WriterId</th>
                        <th>PortfolioUrl</th>
                        <th>CreatedAt</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="WriterId">{{ val.writerId }}</td>
                            <td class="whitespace-nowrap" label="PortfolioUrl">{{ val.portfolioUrl }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Portfolio 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Portfolio :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Portfolio 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="PortfolioId" v-model="selectedRow.portfolioId" :editMode="true"/>
                            <Number label="WriterId" v-model="selectedRow.writerId" :editMode="true"/>
                            <String label="PortfolioUrl" v-model="selectedRow.portfolioUrl" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
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
    name: 'portfolioGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'portfolios',
        createPortfolioDialog: false,
        deletePortfolioDialog: false,
        updatePortfolioDialog: false,
    }),
    watch: {
    },
    methods:{
        async createPortfolio(params){
            try{
                var path = "createPortfolio".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CreatePortfolio 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.createPortfolioDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async deletePortfolio(params){
            try{
                var path = "deletePortfolio".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DeletePortfolio 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.deletePortfolioDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async updatePortfolio(params){
            try{
                var path = "updatePortfolio".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePortfolio 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePortfolioDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>