import { useState } from 'react';
import {
  AppShell,
  Navbar,
  Header,
  Footer,
  Text,
  MediaQuery,
  Burger,
  useMantineTheme,
  Title,
  NavLink,
} from '@mantine/core';
import { IconBook2, IconBrandAmongus, IconHome2 } from '@tabler/icons';
import { createBrowserRouter, Outlet, RouterProvider } from 'react-router-dom';
import routes from '../../routes/routes';
import { Navigation } from '../navigation/Navigation';

export default function Shell() {
  const theme = useMantineTheme();
  const [opened, setOpened] = useState(false);
  return (
    <AppShell
      padding={'xs'}
      navbarOffsetBreakpoint="sm"
      asideOffsetBreakpoint="sm"
      navbar={<Navigation opened={opened} />}
      footer={
        <Footer height={60} p="md">
          Made with ☕ and ❤️ in Offenburg
        </Footer>
      }
      header={
        <Header height={{ base: 50, md: 70 }} p="md">
          <div style={{ display: 'flex', alignItems: 'center', height: '100%' }}>
            <MediaQuery largerThan="sm" styles={{ display: 'none' }}>
              <Burger
                opened={opened}
                onClick={() => setOpened((o) => !o)}
                size="sm"
                color={theme.colors.gray[6]}
                mr="xl"
              />
            </MediaQuery>

            <Title order={3}>sevDesk Lite</Title>
          </div>
        </Header>
      }
    >
      <Outlet />
    </AppShell>
  );
}