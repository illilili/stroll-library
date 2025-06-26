<template>

    <v-card outlined>
        <v-card-title>
            GenerateCoverImage
        </v-card-title>

        <v-card-text>
            <String label="ManuscriptId" v-model="value.manuscriptId" :editMode="editMode"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Summary" v-model="value.summary" :editMode="editMode"/>
            <String label="Keywords" v-model="value.keywords" :editMode="editMode"/>
            <PublicationRequestId offline label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="generateCoverImage"
            >
                GenerateCoverImage
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
    name: 'GenerateCoverImageCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.manuscriptId = '';
        this.value.title = '';
        this.value.summary = '';
        this.value.keywords = '';
        this.value.publicationRequestId = {};
    },
    watch: {
    },
    methods: {
        generateCoverImage() {
            this.$emit('generateCoverImage', this.value);
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

