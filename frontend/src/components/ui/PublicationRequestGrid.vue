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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePublicationRequestMetadataDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 메타데이터 갱신
                </v-btn>
                <v-dialog v-model="updatePublicationRequestMetadataDialog" width="500">
                    <UpdatePublicationRequestMetadata
                        @closeDialog="updatePublicationRequestMetadataDialog = false"
                        @updatePublicationRequestMetadata="updatePublicationRequestMetadata"
                    ></UpdatePublicationRequestMetadata>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ContentId</th>
                        <th>RequestDate</th>
                        <th>Status</th>
                        <th>CoverImageUrl</th>
                        <th>Summary</th>
                        <th>Category</th>
                        <th>SubscriptionPrice</th>
                        <th>EpubUrl</th>
                        <th>PdfUrl</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ContentId">{{ val.contentId }}</td>
                            <td class="whitespace-nowrap" label="RequestDate">{{ val.requestDate }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="CoverImageUrl">{{ val.coverImageUrl }}</td>
                            <td class="whitespace-nowrap" label="Summary">{{ val.summary }}</td>
                            <td class="whitespace-nowrap" label="Category">{{ val.category }}</td>
                            <td class="whitespace-nowrap" label="SubscriptionPrice">{{ val.subscriptionPrice }}</td>
                            <td class="whitespace-nowrap" label="EpubUrl">{{ val.epubUrl }}</td>
                            <td class="whitespace-nowrap" label="PdfUrl">{{ val.pdfUrl }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationRequest 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <PublicationRequest :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationRequest 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="PublicationRequestId" v-model="selectedRow.publicationRequestId" :editMode="true"/>
                            <Number label="ContentId" v-model="selectedRow.contentId" :editMode="true"/>
                            <Date label="RequestDate" v-model="selectedRow.requestDate" :editMode="true"/>
                            <String label="CoverImageUrl" v-model="selectedRow.coverImageUrl" :editMode="true"/>
                            <String label="Summary" v-model="selectedRow.summary" :editMode="true"/>
                            <String label="Category" v-model="selectedRow.category" :editMode="true"/>
                            <Number label="SubscriptionPrice" v-model="selectedRow.subscriptionPrice" :editMode="true"/>
                            <String label="EpubUrl" v-model="selectedRow.epubUrl" :editMode="true"/>
                            <String label="PdfUrl" v-model="selectedRow.pdfUrl" :editMode="true"/>
                            <PublicationRequestStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'publicationRequestGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'publicationRequests',
        updatePublicationRequestMetadataDialog: false,
    }),
    watch: {
    },
    methods:{
        async updatePublicationRequestMetadata(params){
            try{
                var path = "updatePublicationRequestMetadata".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePublicationRequestMetadata 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePublicationRequestMetadataDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>