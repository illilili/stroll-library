<template>

    <v-card outlined>
        <v-card-title>
            RecordPointHistoryEntry
        </v-card-title>

        <v-card-text>
            <String label="PointWalletId" v-model="value.pointWalletId" :editMode="editMode"/>
            <Date label="ChangeDate" v-model="value.changeDate" :editMode="editMode"/>
            <Number label="ChangeAmount" v-model="value.changeAmount" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
            <Number label="BalanceAfterChange" v-model="value.balanceAfterChange" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordPointHistoryEntry"
            >
                RecordPointHistoryEntry
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
    name: 'RecordPointHistoryEntryCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.pointWalletId = '';
        this.value.changeDate = '2025-06-26';
        this.value.changeAmount = 0;
        this.value.description = '';
        this.value.balanceAfterChange = 0;
    },
    watch: {
    },
    methods: {
        recordPointHistoryEntry() {
            this.$emit('recordPointHistoryEntry', this.value);
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

