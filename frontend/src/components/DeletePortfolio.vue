<template>

    <v-card outlined>
        <v-card-title>
            DeletePortfolio
        </v-card-title>

        <v-card-text>
            <Number label="PortfolioId" v-model="value.portfolioId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="deletePortfolio"
            >
                DeletePortfolio
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
    name: 'DeletePortfolioCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.portfolioId = 0;
    },
    watch: {
    },
    methods: {
        deletePortfolio() {
            this.$emit('deletePortfolio', this.value);
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

