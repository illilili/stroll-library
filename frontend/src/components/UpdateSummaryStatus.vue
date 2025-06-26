<template>

    <v-card outlined>
        <v-card-title>
            UpdateSummaryStatus
        </v-card-title>

        <v-card-text>
            <String label="SummaryId" v-model="value.summaryId" :editMode="editMode"/>
            <SummaryStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <Date label="UpdatedAt" v-model="value.updatedAt" :editMode="editMode"/>
            <String label="FailureReason" v-model="value.failureReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateSummaryStatus"
            >
                UpdateSummaryStatus
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
    name: 'UpdateSummaryStatusCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.summaryId = '';
        this.value.status = {};
        this.value.updatedAt = '2025-06-26';
        this.value.failureReason = '';
    },
    watch: {
    },
    methods: {
        updateSummaryStatus() {
            this.$emit('updateSummaryStatus', this.value);
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

