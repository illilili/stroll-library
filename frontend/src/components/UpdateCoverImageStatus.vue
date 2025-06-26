<template>

    <v-card outlined>
        <v-card-title>
            UpdateCoverImageStatus
        </v-card-title>

        <v-card-text>
            <String label="CoverImageId" v-model="value.coverImageId" :editMode="editMode"/>
            <CoverImageStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <Date label="UpdatedAt" v-model="value.updatedAt" :editMode="editMode"/>
            <String label="FailureReason" v-model="value.failureReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateCoverImageStatus"
            >
                UpdateCoverImageStatus
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
    name: 'UpdateCoverImageStatusCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.coverImageId = '';
        this.value.status = {};
        this.value.updatedAt = '2025-06-26';
        this.value.failureReason = '';
    },
    watch: {
    },
    methods: {
        updateCoverImageStatus() {
            this.$emit('updateCoverImageStatus', this.value);
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

