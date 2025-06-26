<template>

    <v-card outlined>
        <v-card-title>
            GenerateSummary
        </v-card-title>

        <v-card-text>
            <String label="ManuscriptId" v-model="value.manuscriptId" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <PublicationRequestId offline label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="generateSummary"
            >
                GenerateSummary
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
    name: 'GenerateSummaryCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.manuscriptId = '';
        this.value.content = '';
        this.value.publicationRequestId = {};
    },
    watch: {
    },
    methods: {
        generateSummary() {
            this.$emit('generateSummary', this.value);
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

