<template>

    <v-card outlined>
        <v-card-title>
            UpdatePublicationRequestMetadata
        </v-card-title>

        <v-card-text>
            <Number label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode"/>
            <String label="CoverImageUrl" v-model="value.coverImageUrl" :editMode="editMode"/>
            <String label="Summary" v-model="value.summary" :editMode="editMode"/>
            <String label="Category" v-model="value.category" :editMode="editMode"/>
            <Number label="SubscriptionPrice" v-model="value.subscriptionPrice" :editMode="editMode"/>
            <String label="EpubUrl" v-model="value.epubUrl" :editMode="editMode"/>
            <String label="PdfUrl" v-model="value.pdfUrl" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePublicationRequestMetadata"
            >
                UpdatePublicationRequestMetadata
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
    name: 'UpdatePublicationRequestMetadataCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationRequestId = 0;
        this.value.coverImageUrl = '';
        this.value.summary = '';
        this.value.category = '';
        this.value.subscriptionPrice = 0;
        this.value.epubUrl = '';
        this.value.pdfUrl = '';
    },
    watch: {
    },
    methods: {
        updatePublicationRequestMetadata() {
            this.$emit('updatePublicationRequestMetadata', this.value);
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

