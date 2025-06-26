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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePublicationMetadataFromConversionDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>전자책 변환 결과 반영
                </v-btn>
                <v-dialog v-model="updatePublicationMetadataFromConversionDialog" width="500">
                    <UpdatePublicationMetadataFromConversion
                        @closeDialog="updatePublicationMetadataFromConversionDialog = false"
                        @updatePublicationMetadataFromConversion="updatePublicationMetadataFromConversion"
                    ></UpdatePublicationMetadataFromConversion>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePublicationMetadataFromSummaryDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>요약 생성 결과 반영
                </v-btn>
                <v-dialog v-model="updatePublicationMetadataFromSummaryDialog" width="500">
                    <UpdatePublicationMetadataFromSummary
                        @closeDialog="updatePublicationMetadataFromSummaryDialog = false"
                        @updatePublicationMetadataFromSummary="updatePublicationMetadataFromSummary"
                    ></UpdatePublicationMetadataFromSummary>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePublicationMetadataFromCategoryAndPricingDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>카테고리 및 구독 요금 결과 반영
                </v-btn>
                <v-dialog v-model="updatePublicationMetadataFromCategoryAndPricingDialog" width="500">
                    <UpdatePublicationMetadataFromCategoryAndPricing
                        @closeDialog="updatePublicationMetadataFromCategoryAndPricingDialog = false"
                        @updatePublicationMetadataFromCategoryAndPricing="updatePublicationMetadataFromCategoryAndPricing"
                    ></UpdatePublicationMetadataFromCategoryAndPricing>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePublicationMetadataFromCoverDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>커버 생성 결과 반영
                </v-btn>
                <v-dialog v-model="updatePublicationMetadataFromCoverDialog" width="500">
                    <UpdatePublicationMetadataFromCover
                        @closeDialog="updatePublicationMetadataFromCoverDialog = false"
                        @updatePublicationMetadataFromCover="updatePublicationMetadataFromCover"
                    ></UpdatePublicationMetadataFromCover>
                </v-dialog>
            </div>
            <PublicationMetadataDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationMetadataDetails>
            <PublicationMetadataList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationMetadataList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ContentId</th>
                        <th>CoverImageUrl</th>
                        <th>Summary</th>
                        <th>Category</th>
                        <th>SubscriptionPrice</th>
                        <th>EpubUrl</th>
                        <th>PdfUrl</th>
                        <th>Status</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>커버 이미지 ID</th>
                        <th>줄거리 설명 ID</th>
                        <th>변환된 원고 ID</th>
                        <th>카테고리 및 요금 ID</th>
                        <th>커버 이미지</th>
                        <th>줄거리 설명</th>
                        <th>변환된 원고</th>
                        <th>카테고리 및 요금</th>
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
                            <td class="whitespace-nowrap" label="CoverImageUrl">{{ val.coverImageUrl }}</td>
                            <td class="whitespace-nowrap" label="Summary">{{ val.summary }}</td>
                            <td class="whitespace-nowrap" label="Category">{{ val.category }}</td>
                            <td class="whitespace-nowrap" label="SubscriptionPrice">{{ val.subscriptionPrice }}</td>
                            <td class="whitespace-nowrap" label="EpubUrl">{{ val.epubUrl }}</td>
                            <td class="whitespace-nowrap" label="PdfUrl">{{ val.pdfUrl }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="커버 이미지">
                                <CoverImageId :editMode="editMode" v-model="val.coverImageId"></CoverImageId>
                            </td>
                            <td class="whitespace-nowrap" label="줄거리 설명">
                                <SummaryId :editMode="editMode" v-model="val.summaryId"></SummaryId>
                            </td>
                            <td class="whitespace-nowrap" label="변환된 원고">
                                <ConvertedManuscriptId :editMode="editMode" v-model="val.convertedManuscriptId"></ConvertedManuscriptId>
                            </td>
                            <td class="whitespace-nowrap" label="카테고리 및 요금">
                                <CategoryAndFeeId :editMode="editMode" v-model="val.categoryAndFeeId"></CategoryAndFeeId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationMetadata 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <PublicationMetadata :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationMetadata 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="PublicationMetadataId" v-model="selectedRow.publicationMetadataId" :editMode="true"/>
                            <Number label="ContentId" v-model="selectedRow.contentId" :editMode="true"/>
                            <String label="CoverImageUrl" v-model="selectedRow.coverImageUrl" :editMode="true"/>
                            <String label="Summary" v-model="selectedRow.summary" :editMode="true"/>
                            <String label="Category" v-model="selectedRow.category" :editMode="true"/>
                            <Number label="SubscriptionPrice" v-model="selectedRow.subscriptionPrice" :editMode="true"/>
                            <String label="EpubUrl" v-model="selectedRow.epubUrl" :editMode="true"/>
                            <String label="PdfUrl" v-model="selectedRow.pdfUrl" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <PublicationStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <CoverImageId offline label="커버 이미지 ID" v-model="selectedRow.coverImageId" :editMode="true"/>
                            <SummaryId offline label="줄거리 설명 ID" v-model="selectedRow.summaryId" :editMode="true"/>
                            <ConvertedManuscriptId offline label="변환된 원고 ID" v-model="selectedRow.convertedManuscriptId" :editMode="true"/>
                            <CategoryAndFeeId offline label="카테고리 및 요금 ID" v-model="selectedRow.categoryAndFeeId" :editMode="true"/>
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
    name: 'publicationMetadataGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'publicationMetadata',
        updatePublicationMetadataFromConversionDialog: false,
        updatePublicationMetadataFromSummaryDialog: false,
        updatePublicationMetadataFromCategoryAndPricingDialog: false,
        updatePublicationMetadataFromCoverDialog: false,
    }),
    watch: {
    },
    methods:{
        async updatePublicationMetadataFromConversion(params){
            try{
                var path = "updatePublicationMetadataFromConversion".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePublicationMetadataFromConversion 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePublicationMetadataFromConversionDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async updatePublicationMetadataFromSummary(params){
            try{
                var path = "updatePublicationMetadataFromSummary".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePublicationMetadataFromSummary 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePublicationMetadataFromSummaryDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async updatePublicationMetadataFromCategoryAndPricing(params){
            try{
                var path = "updatePublicationMetadataFromCategoryAndPricing".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePublicationMetadataFromCategoryAndPricing 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePublicationMetadataFromCategoryAndPricingDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async updatePublicationMetadataFromCover(params){
            try{
                var path = "updatePublicationMetadataFromCover".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePublicationMetadataFromCover 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePublicationMetadataFromCoverDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>