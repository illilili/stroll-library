<template>
    <div>
        <Number
            label="PromotionMessageId"
            v-model="value.promotionMessageId"
            :editMode="editMode"
        />
        <String
            label="Message"
            v-model="value.message"
            :editMode="editMode"
        />
        <Date
            label="DisplayedAt"
            v-model="value.displayedAt"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <PromotionType
            offline
            label="PromotionType"
            v-model="value.promotionType"
            :editMode="editMode"
            @change="change"
        />
        <UserId
            offline
            label="사용자 ID"
            v-model="value.userId"
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
    name: 'PromotionMessage',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "promotionMessages",
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
