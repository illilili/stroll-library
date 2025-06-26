<template>

    <v-card outlined>
        <v-card-title>
            DisplayPromotionMessage
        </v-card-title>

        <v-card-text>
            <UserId offline label="UserId" v-model="value.userId" :editMode="editMode" @change="change"/>
            <PromotionType offline label="PromotionType" v-model="value.promotionType" :editMode="editMode" @change="change"/>
            <String label="Message" v-model="value.message" :editMode="editMode"/>
            <Date label="DisplayedAt" v-model="value.displayedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="displayPromotionMessage"
            >
                DisplayPromotionMessage
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
    name: 'DisplayPromotionMessageCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = {};
        this.value.promotionType = {};
        this.value.message = '';
        this.value.displayedAt = '2025-06-26';
    },
    watch: {
    },
    methods: {
        displayPromotionMessage() {
            this.$emit('displayPromotionMessage', this.value);
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

