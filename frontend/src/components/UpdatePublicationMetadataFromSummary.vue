<template>

    <v-card outlined>
        <v-card-title>
            UpdatePublicationMetadataFromSummary
        </v-card-title>

        <v-card-text>
            <Number label="PublicationMetadataId" v-model="value.publicationMetadataId" :editMode="editMode"/>
            <SummaryId offline label="SummaryId" v-model="value.summaryId" :editMode="editMode" @change="change"/>
            <String label="Summary" v-model="value.summary" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePublicationMetadataFromSummary"
            >
                UpdatePublicationMetadataFromSummary
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
    name: 'UpdatePublicationMetadataFromSummaryCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationMetadataId = 0;
        this.value.summaryId = {};
        this.value.summary = '';
    },
    watch: {
    },
    methods: {
        updatePublicationMetadataFromSummary() {
            this.$emit('updatePublicationMetadataFromSummary', this.value);
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

