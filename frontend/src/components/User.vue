<template>
    <div>
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <Boolean
            label="KtCustomer"
            v-model="value.ktCustomer"
            :editMode="editMode"
        />
        <Number
            label="Points"
            v-model="value.points"
            :editMode="editMode"
        />
        <Number
            offline
            label="포인트 지갑 ID"
            v-model="value.pointWalletId"
            :editMode="editMode"
            @change="change"
        />
        <SubscriptionId
            offline
            label="구독 ID"
            v-model="value.subscriptionId"
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
    name: 'User',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "users",
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
