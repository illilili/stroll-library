<template>
    <div>
        <String
            label="CoverImageId"
            v-model="value.coverImageId"
            :editMode="editMode"
        />
        <String
            label="ManuscriptId"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <String
            label="ImageUrl"
            v-model="value.imageUrl"
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
        <CoverImageStatus
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
    name: 'CoverImage',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "coverImages",
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
