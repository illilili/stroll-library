<template>
    <v-card outlined style="border-radius: 0; margin-top: 10px; padding-bottom: 10px; background-color: #F4F5FA;">
        <v-card-title>
            카테고리 및 요금 상세
        </v-card-title>
    
        <v-card-text style="margin-top:-10px;">
            <v-row no-gutters style="margin: 15px 0px -10px -15px;">
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="CategoryAndFeeId" v-model="value.parameters.categoryAndFeeId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="ManuscriptId" v-model="value.parameters.manuscriptId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="BookId" v-model="value.parameters.bookId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:150px;">
                    <CategoryFeeStatus style="margin-top: 0px; margin-left: 10px;" offline label="Status" v-model="value.parameters.status" :editMode="editMode" @change="change"/>
                </v-col>
                <v-col>
                    <v-btn class="gs-query-search-btn contrast-primary-text"
                        @click="search"
                        small
                        style="margin-left: 35px; margin-top: 30px;"
                        color="primary"
                    >
                        <v-icon small>mdi-magnify</v-icon>검색
                    </v-btn>
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'CategoryAndFeeDetails',
        components:{
        },
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'categoryAndFees/search/categoryAndFeeDetails',
                parameters: {}
            },
        }),
        created() {
        },
        watch: {
        },
        methods: {
            search() {
                let search = null;
                search = this.value;
                this.$emit('search', search);
            },
            change() {
                this.$emit("update:modelValue", this.value);
            },
        }
    }
</script>
<style>
.attributes-list{
    margin-left: 15px;
}
</style>

