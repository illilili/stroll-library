<template>

    <v-card outlined>
        <v-card-title>
            RejectWriterRegistration
        </v-card-title>

        <v-card-text>
            <Number label="RequestId" v-model="value.requestId" :editMode="editMode"/>
            <String label="ReviewedBy" v-model="value.reviewedBy" :editMode="editMode"/>
            <String label="ReviewComment" v-model="value.reviewComment" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="rejectWriterRegistration"
            >
                RejectWriterRegistration
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
    name: 'RejectWriterRegistrationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.requestId = 0;
        this.value.reviewedBy = '';
        this.value.reviewComment = '';
    },
    watch: {
    },
    methods: {
        rejectWriterRegistration() {
            this.$emit('rejectWriterRegistration', this.value);
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

