<template>
    <div>
        <Number
            label="RequestId"
            v-model="value.requestId"
            :editMode="editMode"
        />
        <String
            label="WriterName"
            v-model="value.writerName"
            :editMode="editMode"
        />
        <String
            label="Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <String
            label="Introduction"
            v-model="value.introduction"
            :editMode="editMode"
        />
        <String
            label="PortfolioUrl"
            v-model="value.portfolioUrl"
            :editMode="editMode"
        />
        <Date
            label="SubmittedAt"
            v-model="value.submittedAt"
            :editMode="editMode"
        />
        <Date
            label="ReviewedAt"
            v-model="value.reviewedAt"
            :editMode="editMode"
        />
        <String
            label="ReviewedBy"
            v-model="value.reviewedBy"
            :editMode="editMode"
        />
        <String
            label="ReviewComment"
            v-model="value.reviewComment"
            :editMode="editMode"
        />
        <WriterRegistrationStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <ContentId
            offline
            label="글 ID"
            v-model="value.contentId"
            :editMode="editMode"
            @change="change"
        />
        <PortfolioId
            offline
            label="포트폴리오 ID"
            v-model="value.portfolioId"
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
    name: 'WriterProfile',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "writerProfiles",
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
