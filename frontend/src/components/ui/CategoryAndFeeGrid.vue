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
                <v-btn style="margin-left: 5px;" @click="generateCategoryAndFeeDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>카테고리 및 요금 자동 산정
                </v-btn>
                <v-dialog v-model="generateCategoryAndFeeDialog" width="500">
                    <GenerateCategoryAndFee
                        @closeDialog="generateCategoryAndFeeDialog = false"
                        @generateCategoryAndFee="generateCategoryAndFee"
                    ></GenerateCategoryAndFee>
                </v-dialog>
            </div>
            <CategoryAndFeeDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></CategoryAndFeeDetails>
            <CategoryAndFeeList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></CategoryAndFeeList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ManuscriptId</th>
                        <th>BookId</th>
                        <th>Category</th>
                        <th>FeeAmount</th>
                        <th>Currency</th>
                        <th>Status</th>
                        <th>GeneratedAt</th>
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
                            <td class="whitespace-nowrap" label="BookId">{{ val.bookId }}</td>
                            <td class="whitespace-nowrap" label="Category">{{ val.category }}</td>
                            <td class="whitespace-nowrap" label="FeeAmount">{{ val.feeAmount }}</td>
                            <td class="whitespace-nowrap" label="Currency">{{ val.currency }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="GeneratedAt">{{ val.generatedAt }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">CategoryAndFee 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <CategoryAndFee :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">CategoryAndFee 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="CategoryAndFeeId" v-model="selectedRow.categoryAndFeeId" :editMode="true"/>
                            <String label="ManuscriptId" v-model="selectedRow.manuscriptId" :editMode="true"/>
                            <String label="BookId" v-model="selectedRow.bookId" :editMode="true"/>
                            <String label="Category" v-model="selectedRow.category" :editMode="true"/>
                            <Number label="FeeAmount" v-model="selectedRow.feeAmount" :editMode="true"/>
                            <String label="Currency" v-model="selectedRow.currency" :editMode="true"/>
                            <Date label="GeneratedAt" v-model="selectedRow.generatedAt" :editMode="true"/>
                            <CategoryFeeStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'categoryAndFeeGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'categoryAndFees',
        generateCategoryAndFeeDialog: false,
    }),
    watch: {
    },
    methods:{
        async generateCategoryAndFee(params){
            try{
                var path = "generateCategoryAndFee".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GenerateCategoryAndFee 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.generateCategoryAndFeeDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>