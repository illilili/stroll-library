<template>
    <div>
        <Number
            label="PublicationRequestId"
            v-model="value.publicationRequestId"
            :editMode="editMode"
        />
        <Number
            label="ContentId"
            v-model="value.contentId"
            :editMode="editMode"
        />
        <Date
            label="RequestDate"
            v-model="value.requestDate"
            :editMode="editMode"
        />
        <String
            label="CoverImageUrl"
            v-model="value.coverImageUrl"
            :editMode="editMode"
        />
        <String
            label="Summary"
            v-model="value.summary"
            :editMode="editMode"
        />
        <String
            label="Category"
            v-model="value.category"
            :editMode="editMode"
        />
        <Number
            label="SubscriptionPrice"
            v-model="value.subscriptionPrice"
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
        <PublicationRequestStatus
            offline
            label="Status"
            v-model="value.status"
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
    name: 'PublicationRequest',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "publicationRequests",
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
