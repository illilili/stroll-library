<template>
    <div>
        <Number
            label="BadgeId"
            v-model="value.badgeId"
            :editMode="editMode"
        />
        <Date
            label="GrantedAt"
            v-model="value.grantedAt"
            :editMode="editMode"
        />
        <BadgeType
            offline
            label="Type"
            v-model="value.type"
            :editMode="editMode"
            @change="change"
        />
        <BookId
            offline
            label="도서 ID"
            v-model="value.bookId"
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
    name: 'Badge',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "badges",
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
