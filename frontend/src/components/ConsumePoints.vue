<template>

    <v-card outlined>
        <v-card-title>
            ConsumePoints
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="ContentId" v-model="value.contentId" :editMode="editMode"/>
            <Date label="ConsumedAt" v-model="value.consumedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="consumePoints"
            >
                ConsumePoints
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
    name: 'ConsumePointsCommand',
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
        this.value.contentId = '';
        this.value.consumedAt = '2025-06-26';
    },
    watch: {
    },
    methods: {
        consumePoints() {
            this.$emit('consumePoints', this.value);
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

