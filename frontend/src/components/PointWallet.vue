<template>
    <div>
        <String
            label="PointWalletId"
            v-model="value.pointWalletId"
            :editMode="editMode"
        />
        <String
            label="UserId"
            v-model="value.userId"
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
    name: 'PointWallet',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "pointWallets",
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
