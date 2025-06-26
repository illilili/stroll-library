<template>

    <v-card outlined>
        <v-card-title>
            PurchaseSubscription
        </v-card-title>

        <v-card-text>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="SubscriptionPlan" v-model="value.subscriptionPlan" :editMode="editMode"/>
            <Date label="StartDate" v-model="value.startDate" :editMode="editMode"/>
            <Date label="EndDate" v-model="value.endDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="purchaseSubscription"
            >
                PurchaseSubscription
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
    name: 'PurchaseSubscriptionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = 0;
        this.value.subscriptionPlan = '';
        this.value.startDate = '2025-06-26';
        this.value.endDate = '2025-06-26';
    },
    watch: {
    },
    methods: {
        purchaseSubscription() {
            this.$emit('purchaseSubscription', this.value);
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

