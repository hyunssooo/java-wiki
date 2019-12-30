<template>
    <v-card>
        <v-toolbar
                dense
                dark
        >
            <v-text-field
                    hide-details
                    single-line
            ></v-text-field>

            <v-btn icon>
                <v-icon>search</v-icon>
            </v-btn>
        </v-toolbar>
    </v-card>
</template>

<script>
    export default {
        name: "SearchBar"
    }
</script>

<style scoped>

</style>