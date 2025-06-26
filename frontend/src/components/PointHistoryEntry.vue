<template>

    <div>
        <div class="detail-title">
        PointHistoryEntry
        </div>
        <v-col>
            <Date label="ChangeDate" v-model="value.changeDate" :editMode="editMode"/>
            <Number label="ChangeAmount" v-model="value.changeAmount" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
            <Number label="BalanceAfterChange" v-model="value.balanceAfterChange" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue'
import BasePicker from './base-ui/BasePicker.vue'

export default {
    name: 'PointHistoryEntry',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'pointHistoryEntries',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created() {
        if (Array.isArray(this.modelValue)) {
            this.value = await Promise.all(this.modelValue.map(async (item) => {
                if (item && item.id !== undefined) {
                    return await this.repository.findById(item.id);
                }
                return item;
            }));
        } else {
            this.value = this.modelValue;
            if (this.value && this.value.id !== undefined) {
                this.value = await this.repository.findById(this.value.id);
            }
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

