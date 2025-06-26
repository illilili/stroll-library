<template>
    <v-card outlined style="border-radius: 0; margin-top: 10px; padding-bottom: 10px; background-color: #F4F5FA;">
        <v-card-title>
            줄거리 상세
        </v-card-title>
    
        <v-card-text style="margin-top:-10px;">
            <v-row no-gutters style="margin: 15px 0px -10px -15px;">
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="SummaryId" v-model="value.parameters.summaryId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="ManuscriptId" v-model="value.parameters.manuscriptId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:150px;">
                    <SummaryStatus style="margin-top: 0px; margin-left: 10px;" offline label="Status" v-model="value.parameters.status" :editMode="editMode" @change="change"/>
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
        name: 'SummaryDetails',
        components:{
        },
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'summaries/search/summaryDetails',
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

