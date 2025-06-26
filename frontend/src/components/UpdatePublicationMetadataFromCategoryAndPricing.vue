<template>

    <v-card outlined>
        <v-card-title>
            UpdatePublicationMetadataFromCategoryAndPricing
        </v-card-title>

        <v-card-text>
            <Number label="PublicationMetadataId" v-model="value.publicationMetadataId" :editMode="editMode"/>
            <CategoryAndFeeId offline label="CategoryAndFeeId" v-model="value.categoryAndFeeId" :editMode="editMode" @change="change"/>
            <String label="Category" v-model="value.category" :editMode="editMode"/>
            <Number label="SubscriptionPrice" v-model="value.subscriptionPrice" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePublicationMetadataFromCategoryAndPricing"
            >
                UpdatePublicationMetadataFromCategoryAndPricing
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
    name: 'UpdatePublicationMetadataFromCategoryAndPricingCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationMetadataId = 0;
        this.value.categoryAndFeeId = {};
        this.value.category = '';
        this.value.subscriptionPrice = 0;
    },
    watch: {
    },
    methods: {
        updatePublicationMetadataFromCategoryAndPricing() {
            this.$emit('updatePublicationMetadataFromCategoryAndPricing', this.value);
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

