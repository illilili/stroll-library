<template>

    <v-card outlined>
        <v-card-title>
            ApproveWriterRegistration
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
                    @click="approveWriterRegistration"
            >
                ApproveWriterRegistration
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
    name: 'ApproveWriterRegistrationCommand',
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
        approveWriterRegistration() {
            this.$emit('approveWriterRegistration', this.value);
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

