<template>

    <v-card outlined>
        <v-card-title>
            GrantPoints
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="Reason" v-model="value.reason" :editMode="editMode"/>
            <Date label="GrantedAt" v-model="value.grantedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="grantPoints"
            >
                GrantPoints
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
    name: 'GrantPointsCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = '';
        this.value.amount = 0;
        this.value.reason = '';
        this.value.grantedAt = '2025-06-26';
    },
    watch: {
    },
    methods: {
        grantPoints() {
            this.$emit('grantPoints', this.value);
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

