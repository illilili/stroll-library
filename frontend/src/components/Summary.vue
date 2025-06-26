<template>
    <div>
        <String
            label="SummaryId"
            v-model="value.summaryId"
            :editMode="editMode"
        />
        <String
            label="ManuscriptId"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <String
            label="Content"
            v-model="value.content"
            :editMode="editMode"
        />
        <SummaryStatus
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
    name: 'Summary',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "summaries",
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
