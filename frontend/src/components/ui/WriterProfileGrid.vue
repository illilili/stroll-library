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
                <v-btn style="margin-left: 5px;" @click="requestWriterRegistrationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>작가 등록 신청
                </v-btn>
                <v-dialog v-model="requestWriterRegistrationDialog" width="500">
                    <RequestWriterRegistration
                        @closeDialog="requestWriterRegistrationDialog = false"
                        @requestWriterRegistration="requestWriterRegistration"
                    ></RequestWriterRegistration>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="approveWriterRegistrationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>작가 등록 승인
                </v-btn>
                <v-dialog v-model="approveWriterRegistrationDialog" width="500">
                    <ApproveWriterRegistration
                        @closeDialog="approveWriterRegistrationDialog = false"
                        @approveWriterRegistration="approveWriterRegistration"
                    ></ApproveWriterRegistration>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="rejectWriterRegistrationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>작가 등록 반려
                </v-btn>
                <v-dialog v-model="rejectWriterRegistrationDialog" width="500">
                    <RejectWriterRegistration
                        @closeDialog="rejectWriterRegistrationDialog = false"
                        @rejectWriterRegistration="rejectWriterRegistration"
                    ></RejectWriterRegistration>
                </v-dialog>
            </div>
            <WriterRegistrationList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></WriterRegistrationList>
            <WriterRegistrationDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></WriterRegistrationDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>WriterName</th>
                        <th>Email</th>
                        <th>Introduction</th>
                        <th>PortfolioUrl</th>
                        <th>Status</th>
                        <th>SubmittedAt</th>
                        <th>ReviewedAt</th>
                        <th>ReviewedBy</th>
                        <th>ReviewComment</th>
                        <th>글 ID</th>
                        <th>포트폴리오 ID</th>
                        <th>글</th>
                        <th>포트폴리오</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="WriterName">{{ val.writerName }}</td>
                            <td class="whitespace-nowrap" label="Email">{{ val.email }}</td>
                            <td class="whitespace-nowrap" label="Introduction">{{ val.introduction }}</td>
                            <td class="whitespace-nowrap" label="PortfolioUrl">{{ val.portfolioUrl }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="SubmittedAt">{{ val.submittedAt }}</td>
                            <td class="whitespace-nowrap" label="ReviewedAt">{{ val.reviewedAt }}</td>
                            <td class="whitespace-nowrap" label="ReviewedBy">{{ val.reviewedBy }}</td>
                            <td class="whitespace-nowrap" label="ReviewComment">{{ val.reviewComment }}</td>
                            <td class="whitespace-nowrap" label="글">
                                <ContentId :editMode="editMode" v-model="val.contentId"></ContentId>
                            </td>
                            <td class="whitespace-nowrap" label="포트폴리오">
                                <PortfolioId :editMode="editMode" v-model="val.portfolioId"></PortfolioId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">WriterProfile 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <WriterProfile :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">WriterProfile 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="RequestId" v-model="selectedRow.requestId" :editMode="true"/>
                            <String label="WriterName" v-model="selectedRow.writerName" :editMode="true"/>
                            <String label="Email" v-model="selectedRow.email" :editMode="true"/>
                            <String label="Introduction" v-model="selectedRow.introduction" :editMode="true"/>
                            <String label="PortfolioUrl" v-model="selectedRow.portfolioUrl" :editMode="true"/>
                            <Date label="SubmittedAt" v-model="selectedRow.submittedAt" :editMode="true"/>
                            <Date label="ReviewedAt" v-model="selectedRow.reviewedAt" :editMode="true"/>
                            <String label="ReviewedBy" v-model="selectedRow.reviewedBy" :editMode="true"/>
                            <String label="ReviewComment" v-model="selectedRow.reviewComment" :editMode="true"/>
                            <WriterRegistrationStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <ContentId offline label="글 ID" v-model="selectedRow.contentId" :editMode="true"/>
                            <PortfolioId offline label="포트폴리오 ID" v-model="selectedRow.portfolioId" :editMode="true"/>
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
    name: 'writerProfileGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'writerProfiles',
        requestWriterRegistrationDialog: false,
        approveWriterRegistrationDialog: false,
        rejectWriterRegistrationDialog: false,
    }),
    watch: {
    },
    methods:{
        async requestWriterRegistration(params){
            try{
                var path = "requestWriterRegistration".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RequestWriterRegistration 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestWriterRegistrationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async approveWriterRegistration(params){
            try{
                var path = "approveWriterRegistration".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ApproveWriterRegistration 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.approveWriterRegistrationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async rejectWriterRegistration(params){
            try{
                var path = "rejectWriterRegistration".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RejectWriterRegistration 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.rejectWriterRegistrationDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>