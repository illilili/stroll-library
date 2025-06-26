<template>

    <v-card outlined>
        <v-card-title>
            UpdatePublicationMetadataFromCover
        </v-card-title>

        <v-card-text>
            <Number label="PublicationMetadataId" v-model="value.publicationMetadataId" :editMode="editMode"/>
            <CoverImageId offline label="CoverImageId" v-model="value.coverImageId" :editMode="editMode" @change="change"/>
            <String label="CoverImageUrl" v-model="value.coverImageUrl" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePublicationMetadataFromCover"
            >
                UpdatePublicationMetadataFromCover
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
    name: 'UpdatePublicationMetadataFromCoverCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationMetadataId = 0;
        this.value.coverImageId = {};
        this.value.coverImageUrl = '';
    },
    watch: {
    },
    methods: {
        updatePublicationMetadataFromCover() {
            this.$emit('updatePublicationMetadataFromCover', this.value);
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

