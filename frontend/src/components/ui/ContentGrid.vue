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
                <v-btn style="margin-left: 5px;" @click="draftContentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>글 임시 저장
                </v-btn>
                <v-dialog v-model="draftContentDialog" width="500">
                    <DraftContent
                        @closeDialog="draftContentDialog = false"
                        @draftContent="draftContent"
                    ></DraftContent>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updateContentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>글 수정
                </v-btn>
                <v-dialog v-model="updateContentDialog" width="500">
                    <UpdateContent
                        @closeDialog="updateContentDialog = false"
                        @updateContent="updateContent"
                    ></UpdateContent>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="saveContentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Writer')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>글 최종 저장
                </v-btn>
                <v-dialog v-model="saveContentDialog" width="500">
                    <SaveContent
                        @closeDialog="saveContentDialog = false"
                        @saveContent="saveContent"
                    ></SaveContent>
                </v-dialog>
            </div>
            <ContentDraftList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ContentDraftList>
            <ContentDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ContentDetails>
            <PublicationRequestHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationRequestHistory>
            <ContentFinalList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ContentFinalList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>WriterId</th>
                        <th>Title</th>
                        <th>Summary</th>
                        <th>Keywords</th>
                        <th>Body</th>
                        <th>SaveStatus</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>작가 프로필 ID</th>
                        <th>작가 프로필</th>
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
                            <td class="whitespace-nowrap" label="Title">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="Summary">{{ val.summary }}</td>
                            <td class="whitespace-nowrap" label="Keywords">{{ val.keywords }}</td>
                            <td class="whitespace-nowrap" label="Body">{{ val.body }}</td>
                            <td class="whitespace-nowrap" label="SaveStatus">{{ val.saveStatus }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="작가 프로필">
                                <WriterProfileId :editMode="editMode" v-model="val.writerProfileId"></WriterProfileId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Content 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Content :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Content 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="ContentId" v-model="selectedRow.contentId" :editMode="true"/>
                            <Number label="WriterId" v-model="selectedRow.writerId" :editMode="true"/>
                            <String label="Title" v-model="selectedRow.title" :editMode="true"/>
                            <String label="Summary" v-model="selectedRow.summary" :editMode="true"/>
                            <String label="Keywords" v-model="selectedRow.keywords" :editMode="true"/>
                            <String label="Body" v-model="selectedRow.body" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <ContentSaveStatus offline label="SaveStatus" v-model="selectedRow.saveStatus" :editMode="true"/>
                            <WriterProfileId offline label="작가 프로필 ID" v-model="selectedRow.writerProfileId" :editMode="true"/>
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
    name: 'contentGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'contents',
        draftContentDialog: false,
        updateContentDialog: false,
        saveContentDialog: false,
    }),
    watch: {
    },
    methods:{
        async draftContent(params){
            try{
                var path = "draftContent".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DraftContent 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.draftContentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async updateContent(params){
            try{
                var path = "updateContent".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdateContent 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updateContentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async saveContent(params){
            try{
                var path = "saveContent".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','SaveContent 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.saveContentDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>