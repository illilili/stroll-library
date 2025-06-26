<template>

    <v-card outlined>
        <v-card-title>
            GrantBestsellerBadge
        </v-card-title>

        <v-card-text>
            <String label="BookId" v-model="value.bookId" :editMode="editMode"/>
            <Number label="ViewCount" v-model="value.viewCount" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="grantBestsellerBadge"
            >
                GrantBestsellerBadge
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
    name: 'GrantBestsellerBadgeCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.bookId = '';
        this.value.viewCount = 0;
    },
    watch: {
    },
    methods: {
        grantBestsellerBadge() {
            this.$emit('grantBestsellerBadge', this.value);
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

