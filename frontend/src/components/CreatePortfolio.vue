<template>

    <v-card outlined>
        <v-card-title>
            CreatePortfolio
        </v-card-title>

        <v-card-text>
            <Number label="WriterId" v-model="value.writerId" :editMode="editMode"/>
            <String label="PortfolioUrl" v-model="value.portfolioUrl" :editMode="editMode"/>
            <Date label="CreatedAt" v-model="value.createdAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createPortfolio"
            >
                CreatePortfolio
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
    name: 'CreatePortfolioCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.writerId = 0;
        this.value.portfolioUrl = '';
        this.value.createdAt = '2025-06-26';
    },
    watch: {
    },
    methods: {
        createPortfolio() {
            this.$emit('createPortfolio', this.value);
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

