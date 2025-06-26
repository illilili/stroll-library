import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/writerProfiles',
      component: () => import('../components/ui/WriterProfileGrid.vue'),
    },
    {
      path: '/portfolios',
      component: () => import('../components/ui/PortfolioGrid.vue'),
    },
    {
      path: '/contents',
      component: () => import('../components/ui/ContentGrid.vue'),
    },
    {
      path: '/publicationRequests',
      component: () => import('../components/ui/PublicationRequestGrid.vue'),
    },
    {
      path: '/publicationMetadata',
      component: () => import('../components/ui/PublicationMetadataGrid.vue'),
    },
    {
      path: '/promotionMessages',
      component: () => import('../components/ui/PromotionMessageGrid.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/pointWallets',
      component: () => import('../components/ui/PointWalletGrid.vue'),
    },
    {
      path: '/subscriptions',
      component: () => import('../components/ui/SubscriptionGrid.vue'),
    },
    {
      path: '/coverImages',
      component: () => import('../components/ui/CoverImageGrid.vue'),
    },
    {
      path: '/summaries',
      component: () => import('../components/ui/SummaryGrid.vue'),
    },
    {
      path: '/convertedManuscripts',
      component: () => import('../components/ui/ConvertedManuscriptGrid.vue'),
    },
    {
      path: '/categoryAndFees',
      component: () => import('../components/ui/CategoryAndFeeGrid.vue'),
    },
    {
      path: '/books',
      component: () => import('../components/ui/BookGrid.vue'),
    },
    {
      path: '/badges',
      component: () => import('../components/ui/BadgeGrid.vue'),
    },
  ],
})

export default router;
