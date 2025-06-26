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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="grantBestsellerBadgeDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>베스트셀러 배지 부여
                </v-btn>
                <v-dialog v-model="grantBestsellerBadgeDialog" width="500">
                    <GrantBestsellerBadge
                        @closeDialog="grantBestsellerBadgeDialog = false"
                        @grantBestsellerBadge="grantBestsellerBadge"
                    ></GrantBestsellerBadge>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="deleteBookDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>도서 삭제
                </v-btn>
                <v-dialog v-model="deleteBookDialog" width="500">
                    <DeleteBook
                        @closeDialog="deleteBookDialog = false"
                        @deleteBook="deleteBook"
                    ></DeleteBook>
                </v-dialog>
            </div>
            <BookList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BookList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>AuthorName</th>
                        <th>ViewCount</th>
                        <th>Status</th>
                        <th>BestsellerBadge</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Title">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="AuthorName">{{ val.authorName }}</td>
                            <td class="whitespace-nowrap" label="ViewCount">{{ val.viewCount }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="BestsellerBadge">{{ val.bestsellerBadge }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Book 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Book :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Book 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="BookId" v-model="selectedRow.bookId" :editMode="true"/>
                            <String label="Title" v-model="selectedRow.title" :editMode="true"/>
                            <Number label="ViewCount" v-model="selectedRow.viewCount" :editMode="true"/>
                            <Boolean label="BestsellerBadge" v-model="selectedRow.bestsellerBadge" :editMode="true"/>
                            <AuthorName offline label="AuthorName" v-model="selectedRow.authorName" :editMode="true"/>
                            <BookStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'bookGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'books',
        grantBestsellerBadgeDialog: false,
        deleteBookDialog: false,
    }),
    watch: {
    },
    methods:{
        async grantBestsellerBadge(params){
            try{
                var path = "grantBestsellerBadge".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GrantBestsellerBadge 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.grantBestsellerBadgeDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async deleteBook(params){
            try{
                var path = "deleteBook".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DeleteBook 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.deleteBookDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>