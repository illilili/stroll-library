<template>
    <div>
        <Number
            label="ContentId"
            v-model="value.contentId"
            :editMode="editMode"
        />
        <Number
            label="WriterId"
            v-model="value.writerId"
            :editMode="editMode"
        />
        <String
            label="Title"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="Summary"
            v-model="value.summary"
            :editMode="editMode"
        />
        <String
            label="Keywords"
            v-model="value.keywords"
            :editMode="editMode"
        />
        <String
            label="Body"
            v-model="value.body"
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
        <ContentSaveStatus
            offline
            label="SaveStatus"
            v-model="value.saveStatus"
            :editMode="editMode"
            @change="change"
        />
        <WriterProfileId
            offline
            label="작가 프로필 ID"
            v-model="value.writerProfileId"
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
    name: 'Content',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "contents",
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
