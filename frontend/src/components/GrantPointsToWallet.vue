<template>

    <v-card outlined>
        <v-card-title>
            GrantPointsToWallet
        </v-card-title>

        <v-card-text>
            <String label="PointWalletId" v-model="value.pointWalletId" :editMode="editMode"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="Reason" v-model="value.reason" :editMode="editMode"/>
            <Date label="GrantedAt" v-model="value.grantedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="grantPointsToWallet"
            >
                GrantPointsToWallet
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
    name: 'GrantPointsToWalletCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.pointWalletId = '';
        this.value.amount = 0;
        this.value.reason = '';
        this.value.grantedAt = '2025-06-26';
    },
    watch: {
    },
    methods: {
        grantPointsToWallet() {
            this.$emit('grantPointsToWallet', this.value);
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

