<template>
    <div>
        <Number
            label="PortfolioId"
            v-model="value.portfolioId"
            :editMode="editMode"
        />
        <Number
            label="WriterId"
            v-model="value.writerId"
            :editMode="editMode"
        />
        <String
            label="PortfolioUrl"
            v-model="value.portfolioUrl"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
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
    name: 'Portfolio',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "portfolios",
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
