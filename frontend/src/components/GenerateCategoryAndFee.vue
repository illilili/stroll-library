<template>

    <v-card outlined>
        <v-card-title>
            GenerateCategoryAndFee
        </v-card-title>

        <v-card-text>
            <String label="ManuscriptId" v-model="value.manuscriptId" :editMode="editMode"/>
            <String label="Summary" v-model="value.summary" :editMode="editMode"/>
            <String label="Metadata" v-model="value.metadata" :editMode="editMode"/>
            <PublicationRequestId offline label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="generateCategoryAndFee"
            >
                GenerateCategoryAndFee
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'GenerateCategoryAndFeeCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.manuscriptId = '';
        this.value.summary = '';
        this.value.metadata = '';
        this.value.publicationRequestId = {};
    },
    watch: {
    },
    methods: {
        generateCategoryAndFee() {
            this.$emit('generateCategoryAndFee', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

