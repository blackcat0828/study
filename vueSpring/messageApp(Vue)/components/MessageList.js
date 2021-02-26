import MessageListItem from './MessageListItem.js';
//import lifecycleLogger from '../mixins/lifecycle-logger.mixin.js';
import LifecycleLogger from '../plugins/lifecycle-logger.plugin.js';


Vue.use(LifecycleLogger, {beforeMount: false, created: true, mounted: true})

export default {
        name: 'MessageList',
        //mixins: [lifecycleLogger],
        template: 
        `<ul><message-list-item v-for="item in items" :item="item" 
           :key="item.id"  @delete="deleteMessage(item)"></message-list-item></ul>`,
        

        components: {
            MessageListItem
        },

        props: {
            items: {
                type: Array,
                required: true
            }
        },

        methods: {
            deleteMessage(message){
                this.$emit('delete', message);
            }
        }
};