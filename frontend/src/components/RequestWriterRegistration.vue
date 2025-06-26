<template>

    <v-card outlined>
        <v-card-title>
            RequestWriterRegistration
        </v-card-title>

        <v-card-text>
            <String label="WriterName" v-model="value.writerName" :editMode="editMode"/>
            <String label="Email" v-model="value.email" :editMode="editMode"/>
            <String label="Introduction" v-model="value.introduction" :editMode="editMode"/>
            <String label="PortfolioUrl" v-model="value.portfolioUrl" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestWriterRegistration"
            >
                RequestWriterRegistration
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
    name: 'RequestWriterRegistrationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.writerName = '';
        this.value.email = '';
        this.value.introduction = '';
        this.value.portfolioUrl = '';
    },
    watch: {
    },
    methods: {
        requestWriterRegistration() {
            this.$emit('requestWriterRegistration', this.value);
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

