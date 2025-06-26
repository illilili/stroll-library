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
                <v-btn style="margin-left: 5px;" @click="convertManuscriptDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>원고 파일 변환 요청
                </v-btn>
                <v-dialog v-model="convertManuscriptDialog" width="500">
                    <ConvertManuscript
                        @closeDialog="convertManuscriptDialog = false"
                        @convertManuscript="convertManuscript"
                    ></ConvertManuscript>
                </v-dialog>
            </div>
            <ConvertedManuscriptDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ConvertedManuscriptDetails>
            <ConvertedManuscriptList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ConvertedManuscriptList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ManuscriptId</th>
                        <th>EpubUrl</th>
                        <th>PdfUrl</th>
                        <th>Status</th>
                        <th>ConvertedAt</th>
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
                            <td class="whitespace-nowrap" label="EpubUrl">{{ val.epubUrl }}</td>
                            <td class="whitespace-nowrap" label="PdfUrl">{{ val.pdfUrl }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="ConvertedAt">{{ val.convertedAt }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">ConvertedManuscript 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <ConvertedManuscript :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">ConvertedManuscript 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="ConvertedManuscriptId" v-model="selectedRow.convertedManuscriptId" :editMode="true"/>
                            <String label="ManuscriptId" v-model="selectedRow.manuscriptId" :editMode="true"/>
                            <String label="EpubUrl" v-model="selectedRow.epubUrl" :editMode="true"/>
                            <String label="PdfUrl" v-model="selectedRow.pdfUrl" :editMode="true"/>
                            <Date label="ConvertedAt" v-model="selectedRow.convertedAt" :editMode="true"/>
                            <ManuscriptConvertStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'convertedManuscriptGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'convertedManuscripts',
        convertManuscriptDialog: false,
    }),
    watch: {
    },
    methods:{
        async convertManuscript(params){
            try{
                var path = "convertManuscript".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ConvertManuscript 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.convertManuscriptDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>