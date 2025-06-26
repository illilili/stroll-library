<template>

    <v-card outlined>
        <v-card-title>
            UpdatePublicationMetadataFromConversion
        </v-card-title>

        <v-card-text>
            <Number label="PublicationMetadataId" v-model="value.publicationMetadataId" :editMode="editMode"/>
            <ConvertedManuscriptId offline label="ConvertedManuscriptId" v-model="value.convertedManuscriptId" :editMode="editMode" @change="change"/>
            <String label="EpubUrl" v-model="value.epubUrl" :editMode="editMode"/>
            <String label="PdfUrl" v-model="value.pdfUrl" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePublicationMetadataFromConversion"
            >
                UpdatePublicationMetadataFromConversion
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
    name: 'UpdatePublicationMetadataFromConversionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationMetadataId = 0;
        this.value.convertedManuscriptId = {};
        this.value.epubUrl = '';
        this.value.pdfUrl = '';
    },
    watch: {
    },
    methods: {
        updatePublicationMetadataFromConversion() {
            this.$emit('updatePublicationMetadataFromConversion', this.value);
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

