<template>

    <v-card outlined>
        <v-card-title>
            UpdatePortfolio
        </v-card-title>

        <v-card-text>
            <Number label="PortfolioId" v-model="value.portfolioId" :editMode="editMode"/>
            <String label="PortfolioUrl" v-model="value.portfolioUrl" :editMode="editMode"/>
            <Date label="UpdatedAt" v-model="value.updatedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePortfolio"
            >
                UpdatePortfolio
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
    name: 'UpdatePortfolioCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.portfolioId = 0;
        this.value.portfolioUrl = '';
        this.value.updatedAt = '2025-06-26';
    },
    watch: {
    },
    methods: {
        updatePortfolio() {
            this.$emit('updatePortfolio', this.value);
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

