<template>
    <div>
        <Number
            label="PublicationMetadataId"
            v-model="value.publicationMetadataId"
            :editMode="editMode"
        />
        <Number
            label="ContentId"
            v-model="value.contentId"
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
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="UpdatedAt"
            v-model="value.updatedAt"
            :editMode="editMode"
        />
        <PublicationStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <CoverImageId
            offline
            label="커버 이미지 ID"
            v-model="value.coverImageId"
            :editMode="editMode"
            @change="change"
        />
        <SummaryId
            offline
            label="줄거리 설명 ID"
            v-model="value.summaryId"
            :editMode="editMode"
            @change="change"
        />
        <ConvertedManuscriptId
            offline
            label="변환된 원고 ID"
            v-model="value.convertedManuscriptId"
            :editMode="editMode"
            @change="change"
        />
        <CategoryAndFeeId
            offline
            label="카테고리 및 요금 ID"
            v-model="value.categoryAndFeeId"
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
    name: 'PublicationMetadata',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "publicationMetadata",
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
