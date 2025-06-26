<template>

    <v-card outlined>
        <v-card-title>
            SaveContent
        </v-card-title>

        <v-card-text>
            <Number label="WriterId" v-model="value.writerId" :editMode="editMode"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Body" v-model="value.body" :editMode="editMode"/>
            <String label="Keywords" v-model="value.keywords" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="saveContent"
            >
                SaveContent
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
    name: 'SaveContentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.writerId = 0;
        this.value.title = '';
        this.value.body = '';
        this.value.keywords = '';
    },
    watch: {
    },
    methods: {
        saveContent() {
            this.$emit('saveContent', this.value);
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

