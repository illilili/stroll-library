<template>
    <div>
        <String
            label="CategoryAndFeeId"
            v-model="value.categoryAndFeeId"
            :editMode="editMode"
        />
        <String
            label="ManuscriptId"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <String
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <String
            label="Category"
            v-model="value.category"
            :editMode="editMode"
        />
        <Number
            label="FeeAmount"
            v-model="value.feeAmount"
            :editMode="editMode"
        />
        <String
            label="Currency"
            v-model="value.currency"
            :editMode="editMode"
        />
        <Date
            label="GeneratedAt"
            v-model="value.generatedAt"
            :editMode="editMode"
        />
        <CategoryFeeStatus
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
    name: 'CategoryAndFee',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "categoryAndFees",
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
