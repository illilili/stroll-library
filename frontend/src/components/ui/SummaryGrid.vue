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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updateSummaryStatusDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>줄거리 상태 변경
                </v-btn>
                <v-dialog v-model="updateSummaryStatusDialog" width="500">
                    <UpdateSummaryStatus
                        @closeDialog="updateSummaryStatusDialog = false"
                        @updateSummaryStatus="updateSummaryStatus"
                    ></UpdateSummaryStatus>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="generateSummaryDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>줄거리 자동 생성
                </v-btn>
                <v-dialog v-model="generateSummaryDialog" width="500">
                    <GenerateSummary
                        @closeDialog="generateSummaryDialog = false"
                        @generateSummary="generateSummary"
                    ></GenerateSummary>
                </v-dialog>
            </div>
            <SummaryDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SummaryDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ManuscriptId</th>
                        <th>Content</th>
                        <th>Status</th>
                        <th>출간 요청 ID</th>
                        <th>출간 요청</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ManuscriptId">{{ val.manuscriptId }}</td>
                            <td class="whitespace-nowrap" label="Content">{{ val.content }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="출간 요청">
                                <PublicationRequestId :editMode="editMode" v-model="val.publicationRequestId"></PublicationRequestId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Summary 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Summary :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Summary 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="SummaryId" v-model="selectedRow.summaryId" :editMode="true"/>
                            <String label="ManuscriptId" v-model="selectedRow.manuscriptId" :editMode="true"/>
                            <String label="Content" v-model="selectedRow.content" :editMode="true"/>
                            <SummaryStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <PublicationRequestId offline label="출간 요청 ID" v-model="selectedRow.publicationRequestId" :editMode="true"/>
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
    name: 'summaryGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'summaries',
        updateSummaryStatusDialog: false,
        generateSummaryDialog: false,
    }),
    watch: {
    },
    methods:{
        async updateSummaryStatus(params){
            try{
                var path = "updateSummaryStatus".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdateSummaryStatus 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updateSummaryStatusDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async generateSummary(params){
            try{
                var path = "generateSummary".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GenerateSummary 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.generateSummaryDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>