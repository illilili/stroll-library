<template>
    <div>
        <String
            label="ConvertedManuscriptId"
            v-model="value.convertedManuscriptId"
            :editMode="editMode"
        />
        <String
            label="ManuscriptId"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <String
            label="EpubUrl"
            v-model="value.epubUrl"
            :editMode="editMode"
        />
        <String
            label="PdfUrl"
            v-model="value.pdfUrl"
            :editMode="editMode"
        />
        <Date
            label="ConvertedAt"
            v-model="value.convertedAt"
            :editMode="editMode"
        />
        <ManuscriptConvertStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <PublicationRequestId
            offline
            label="출간 요청 ID"
            v-model="value.publicationRequestId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'ConvertedManuscript',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "convertedManuscripts",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
